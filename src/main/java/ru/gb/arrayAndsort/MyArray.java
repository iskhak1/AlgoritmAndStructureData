package ru.gb.arrayAndsort;

public class MyArray {
    private int[] arr;
    private int capacity;

    //new int[5];
    public MyArray(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }

    // = {1,2,3,4,5};
    public MyArray(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    void display() {
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int get(int idx) {
        return arr[idx];
    }

    public void set(int value, int idx) {
        arr[idx] = value;
    }

    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }


    boolean deleteAll(int value) {
        int a = 0;
        System.out.println(capacity);
        for (int i = 0; i < capacity; i++) if (arr[i] == value) a++;
        while(a!=0){
            for (int i = 0; i < this.capacity; i++) if (this.arr[i] == value)
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
            --capacity;
            a--;
        }
        return false;
    }

    boolean deleteAll(){
        int[] toNew = new int[0];
        this.arr = toNew;
        while(capacity!=0){
            for (int i = 0; i < this.capacity; i++)
                --capacity;
        }
        return false;
    }


    public void insert(int idx, int value){
        int[] arr1 = new int[idx];
        int[] arr2 = new int[capacity-idx];
        for (int i = 0; i < capacity; i++)if(i<idx)arr1[i] = this.arr[i];
        for (int i = 0; i < capacity-idx; i++) arr2[i] = this.arr[i+idx];
        capacity++;
        this.arr = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            if (i < idx) this.arr[i] = arr1[i];
            else {
                this.arr[i] = value;
                break;
            }
        }
        for (int i = 0; i < arr2.length; i++)this.arr[(arr1.length+1)+i]=arr2[i];
    }






    void append(int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

    public boolean isInArray(int value) { // O(n)
        for (int i = 0; i < this.capacity; i++)
            if (this.arr[i] == value)
                return true;
        return false;
    }

    //O(log(N))
    public boolean hasValue(int value) {
        int low = 0;
        int high = this.capacity - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() {
        for (int iter = 0; iter < capacity; iter++)
            for (int idx = 0; idx < capacity - 1; idx++)
                if (this.arr[idx] > this.arr[idx + 1])
                    swap(idx, idx + 1);
    }

    public void sortSelect() {
        for (int idx = 0; idx < capacity; idx++) {
            int curr = idx;
            for (int srch = idx + 1; srch < capacity; srch++)
                if (this.arr[srch] < this.arr[curr])
                    curr = srch;
            if (curr != idx)
                swap(idx, curr);
        }
    }

    public void sortInsert() {
        for (int curr = 1; curr < capacity; curr++) {
            int temp = this.arr[curr];
            int move = curr;
            while (move > 0 && this.arr[move - 1] >= temp) {
                this.arr[move] = this.arr[move - 1];
                move--;
            }
            this.arr[move] = temp;
        }
    }
}
