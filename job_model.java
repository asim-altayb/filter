package joud.asim.sd;

public class job_model {

    String job_name;
    String job_place;
    String sek_type;
    String year_ex;
    String age;
    String spicialization;
    String gua;
    String adve_data;
    String end_data;
    String salary;

    public job_model(String job_name, String job_place, String sek_type, String year_ex, String age, String spicialization, String gua, String adve_data, String end_data ,String salary) {
        this.job_name = job_name;
        this.job_place = job_place;
        this.sek_type = sek_type;
        this.year_ex = year_ex;
        this.age = age;
        this.spicialization = spicialization;
        this.gua = gua;
        this.adve_data = adve_data;
        this.end_data = end_data;
        this.salary=salary;
    }


    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getJob_place() {
        return job_place;
    }

    public void setJob_place(String job_place) {
        this.job_place = job_place;
    }

    public String getSek_type() {
        return sek_type;
    }

    public void setSek_type(String sek_type) {
        this.sek_type = sek_type;
    }

    public String getYear_ex() {
        return year_ex;
    }

    public void setYear_ex(String year_ex) {
        this.year_ex = year_ex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpicialization() {
        return spicialization;
    }

    public void setSpicialization(String spicialization) {
        this.spicialization = spicialization;
    }

    public String getGua() {
        return gua;
    }

    public void setGua(String gua) {
        this.gua = gua;
    }

    public String getAdve_data() {
        return adve_data;
    }

    public void setAdve_data(String adve_data) {
        this.adve_data = adve_data;
    }

    public String getEnd_data() {
        return end_data;
    }

    public void setEnd_data(String end_data) {
        this.end_data = end_data;
    }
}
