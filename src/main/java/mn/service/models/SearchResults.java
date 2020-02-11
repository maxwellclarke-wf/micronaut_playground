package mn.service.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchResults<T> {

    @JsonProperty("total_count")
    private int totalCount;
    @JsonProperty("incomplete_results")
    boolean isIncomplete;

    List<T> items;
}
