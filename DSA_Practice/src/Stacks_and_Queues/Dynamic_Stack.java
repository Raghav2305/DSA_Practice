package Stacks_and_Queues;

public class Dynamic_Stack extends Custom_Stack{
    public Dynamic_Stack(){
        super();
    }
    public Dynamic_Stack(int size){
        super(size);
    }

    @Override
    public boolean push(int val) throws Exception {
        if(this.isFull()){
            int [] temp = new int[2 * data.length];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        return super.push(val);
    }
}
