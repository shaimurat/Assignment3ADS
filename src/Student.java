public class Student {
    private String name;
    private String surname;
    public Student(){}

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsname() {
        return surname;
    }

    public void setsname(String sname) {
        this.surname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sname='" + surname + '\'' +
                '}';
    }
}
