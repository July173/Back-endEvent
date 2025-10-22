package com.back.control_event.dto;
import java.util.List;

public class MenuDTO {
    private String moduleName;
    private List<FormDTO> forms;

    public String getModuleName() { return moduleName; }
    public void setModuleName(String moduleName) { this.moduleName = moduleName; }
    public List<FormDTO> getForms() { return forms; }
    public void setForms(List<FormDTO> forms) { this.forms = forms; }
}
