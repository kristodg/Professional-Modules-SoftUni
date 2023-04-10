package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public abstract class BaseService implements Service{

    //name, capacity, supplements, robots

    private String name;
    private int capacity;

    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    protected BaseService() {
    }

    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;

    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        //нямаме място за робота
        if (this.getRobots().size() >= this.capacity){
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        //ако имаме място за робота
        this.getRobots().add(robot);

    }

    @Override
    public void removeRobot(Robot robot) {
        this.getRobots().remove(robot);

    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);

    }

    @Override
    public void feeding() {
        for (Robot robot : this.getRobots()) {
            robot.eating();
        }

    }

    @Override
    public int sumHardness() {
        int sum = 0;
        for (Supplement supplement : this.getSupplements()) {
            sum += supplement.getHardness();
        }

        return sum;
    }

    @Override
    public String getStatistics() {
        StringBuilder builder =  new StringBuilder();
        builder.append(String.format("%s %s:%n", this.getName(), this.getClass().getSimpleName()));
        builder.append("Robots: ");
        if (this.getRobots().isEmpty()){
            builder.append("none");
        }else{
            builder.append(this.getRobots().stream()
                    .map(Robot::getName)
                    .collect(Collectors.joining(" ")).trim());
        }
        builder.append(String.format("Supplements: %d Hardness: %d", this.getSupplements().size(), this.sumHardness()));
        return builder.toString();
    }

    public int getCapacity() {
        return this.robots.size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
