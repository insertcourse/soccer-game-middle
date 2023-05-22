public abstract class Soccer{
    private String name;

    Soccer(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    abstract boolean shoot();

}
