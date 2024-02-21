public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        items = new int[length];
    }



    public void insert(int item){
        if(count == items.length){
            int[] newItems = new int[ count * 2 ] ;
            for(int i = 0; i < count; i++){
            newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;

    }

    public void removeAt(int index) {
        if(index < 0 || index >= count)
        throw new IllegalArgumentException();

        for(int i = index; i < count; i++)
        items[i] = items[i+1];

        count--;
    }

    public int indexOf(int item){
 
        for(int i = 0; i < count; i++)
            if(items[i] == item)
            return i;
         return -1;
        
    }

    public void print(){
        int i = 0;
        System.out.print("[ ");
        while(i < count)
        System.out.print(items[i++] + ", ");
        System.out.print(" ]");
    }
}
