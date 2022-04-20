public class MyOrderedList<Type extends Comparable<Type>> {
    private MyArrayList<Type> list = new MyArrayList<>();
    public long comparisons = 1;

    public void add(Type item){

        if(!isEmpty()){
            comparisons++;
            for(int i=0;i<list.size()+1;i++){
                if(i == list.size()){
                    list.insert(item,i);
                    break;
                }
                comparisons++;
                if(item.compareTo(list.get(i)) <= 0){
                    list.insert(item,i);
                    break;
                }
            }
        } else {
            comparisons++;
            list.insert(item, 0);
        }

    }
    public Type remove(Type item){
        for (int i = 0; i<size(); i++){
            if(item.compareTo(list.get(i)) == 0){
                list.remove(i);
                return item;
            }
        }
        return null;
    }
    //UPGRADE TO RETURN TYPE
    public Type binarySearch(Type item){

        if(list.size() == 0){
            return null;
        }
        return binarySearch(item, 0,size()-1);
    }

    private Type binarySearch(Type item, int start, int finish){
        comparisons++;
        if(finish >= start && start <= list.size() - 1){
            int mid = start + (finish - start)/2;

            if(list.get(mid).compareTo(item) == 0){

                return item;
            }

            if(list.get(mid).compareTo(item) > 0){

                return binarySearch(item,start, mid-1);
            }

            return binarySearch(item, mid+1, finish);
        }

        return null;

    }
    public Type get(int index){
        return list.get(index);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public String toString(){
        return  list.toString();
    }

}
