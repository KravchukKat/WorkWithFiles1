package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Group {

    @JsonProperty("group")
    private String group;
    private List<UserName> checklist;

    public String getGroup() {
        return group;
    }

    public List<UserName> getChecklist() {
        return checklist;
    }
}
