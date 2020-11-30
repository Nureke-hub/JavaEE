package db.classes;

public class Languages {
    private Long id;
    private String name;
    private String code;


    public Languages() {
    }

    public Languages(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Languages(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Languages(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
