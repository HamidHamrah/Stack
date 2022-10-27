public class CircularBuffer {
    char [] Buffer;
    int size;
    int counter;
    int head;
    int tail;
         CircularBuffer(int size){
             this.Buffer=new char[size];
             this.size=0;
             this.counter=0;
             this.head=0;
             this.tail=0;
    }
    public void push(char value){
            Buffer[tail]=value;
            tail=(tail+1)%size;
            counter++;
    }
    public void pullFront(){

    }
}
