package br.com.cya.kafka_project.dto;

public class UserRequestDTO {
    private String name;
    private String email;
    private Integer number;

    public UserRequestDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
