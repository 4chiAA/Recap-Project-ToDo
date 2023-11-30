package bootcamp.neuefische.recapprojecttodo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping("/api/todo/{id}")
    public ToDo findToDoById(@PathVariable String id){
        return toDoService.findToDoById(id);
    }

    @GetMapping("/api/todo")
    public List<ToDo> getToDos(){
        return toDoService.getToDos();
    }

    @PostMapping("/api/todo")
    public ToDo addToDo(@RequestBody ToDoDTO toDo){
        return toDoService.addToDo(toDo);
    }

    @PutMapping("/api/todo/{id}")
    public ToDo updateToDo(@PathVariable String id, @RequestBody ToDoDTO toDo) {
        return toDoService.updateToDo(id, toDo);
    }

    @DeleteMapping("/api/todo/{id}")
    public void removeToDoById(@PathVariable String id) {
        toDoService.removeToDoById(id);
    }


    /*
    @GetMapping("/board/todo")
    public  getTodo(){

    }
    */


    //Request URL:
    //http://localhost:8080/api/todo
    //Request Method:
    //GET
    //Content-Type:
    //application/json

    //Request URL:
    //http://localhost:8080/board/todo
    //Request Method:
    //GET
    //Content-Type:
    //text/html;charset=UTF-8

    //Request URL:
    //http://localhost:8080/board/doing
    //Request Method:
    //GET
    //Content-Type:
    //text/html;charset=UTF-8

    //Request URL:
    //http://localhost:8080/board/done
    //Request Method:
    //GET
    //Content-Type:
    //text/html;charset=UTF-8
}
