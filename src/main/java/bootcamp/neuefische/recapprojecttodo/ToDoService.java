package bootcamp.neuefische.recapprojecttodo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;
    private final IDService idService;

    public ToDo findToDoById(String id) {
        return toDoRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Todo not found!"));
    }

    public List<ToDo> getToDos() {
        return toDoRepo.findAll();
    }

    public ToDo addToDo(ToDoDTO toDo) {
        ToDo newToDo = new ToDo(idService.randomID(), toDo.description(), toDo.status());
        return toDoRepo.save(newToDo);
    }

    public ToDo updateToDo(String id, ToDoDTO toDo) {
        ToDo updatedToDo = new ToDo(id, toDo.description(), toDo.status());
        return toDoRepo.save(updatedToDo);
    }

    public void removeToDoById(String id){
        toDoRepo.deleteById(id);
    }


}
