package JDBC_Hondenuitlaat.project.model;

import java.time.LocalDate;

public class Walk {
    private int walkId;
    private Dog walkDog;
    private LocalDate walkDate;
    private double duration;
    private Employee walkEmployee;

    public Walk(Dog walkDog, LocalDate walkDate, double duration, Employee walkEmployee) {
        this.walkDog = walkDog;
        this.walkDate = walkDate;
        this.duration = duration;
        this.walkEmployee = walkEmployee;
    }

    public Walk(int walkId, Dog walkDog, LocalDate walkDate, double duration, Employee walkEmployee) {
        this(walkDog, walkDate, duration, walkEmployee);
        this.walkId = walkId;
    }

    public int getWalkId() {
        return walkId;
    }

    public void setWalkId(int walkId) {
        this.walkId = walkId;
    }

    public Dog getWalkDog() {
        return walkDog;
    }

    public void setWalkDog(Dog walkDog) {
        this.walkDog = walkDog;
    }

    public LocalDate getWalkDate() {
        return walkDate;
    }

    public void setWalkDate(LocalDate walkDate) {
        this.walkDate = walkDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Employee getWalkEmployee() {
        return walkEmployee;
    }

    public void setWalkEmployee(Employee walkEmployee) {
        this.walkEmployee = walkEmployee;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Wandeling " + walkId + ": ");
        result.append(walkDog.toString());
        result.append(" uitgelaten op ");
        result.append(walkDate);
        result.append(" gedurende " + duration + " uur");
        result.append(" door " + walkEmployee.toString());
        return result.toString();
    }

}
