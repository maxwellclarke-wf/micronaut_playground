package mn.service.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class SearchItem {
    Map<String, Object> fields = new HashMap<>();

    private String url;



    @JsonAnyGetter
    public Map<String, Object> getFields() {
        return fields;
    }

    @JsonAnySetter
    public void setField(String name, Object value) {
        fields.put(name, value);
    }
}
