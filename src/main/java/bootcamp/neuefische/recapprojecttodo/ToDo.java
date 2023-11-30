package bootcamp.neuefische.recapprojecttodo;

import lombok.With;

public record ToDo(
        String id,
        String description,
        String status
) {
}
