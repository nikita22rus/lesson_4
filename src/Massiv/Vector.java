package Massiv;

class Massive{
    public Massive(int size) {
        this.size = size;
        massive = new int[size];

    }

    private int size;
    private int[] massive;

    public int getSize() {
        return size;
    }

    public void setAllEl (int[] allel){
        if (allel.length > getSize()){
            throw new RuntimeException("ERR");
        }
        for (int i = 0; i < allel.length;i++) {
            this.setEl(allel[i],i);
        }
    }

    public void setEl (int el,int index) { // Добавление эллемента в массив
        if (index >= getSize()) {
            throw new RuntimeException("ERR");
        }
        massive[index] = el;

    }

    public int getEl (int index) {
        if (index >= massive.length) {
            throw new RuntimeException("ERR");
        }

        return massive[index];
    }

    public void printElments (int index_1,int index_2) {
        String s = "(";
        for (int i = index_1; i <= index_2; i++ ) {
            s += this.getEl(i) + ",";
        }
        s += ")";
        System.out.println(s);
    }
    public Massive sum (Massive b) {
        if (this.getSize() == b.getSize()){
            for (int i = 0; i < this.getSize();i++) {
                int newel = this.getEl(i) + b.getEl(i);
                this.setEl(newel,i);
            }
            return this;

        }
        else {
        }
        return this;
    }

    public Massive sub (Massive b) {
        if (this.getSize() == b.getSize()){
            for (int i = 0; i < this.getSize();i++) {
                int newel = this.getEl(i) - b.getEl(i);
                this.setEl(newel,i);
            }
            return this;

        }
        else {
            System.out.println("ERROR: Can't sum these massives");
        }
        return this;
    }

    public Massive mult (int b) {
        for (int i = 0; i < this.getSize();i++) {
            int newelement = this.getEl(i)*b;
            this.setEl(newelement,i); }
        return this;
    }
    public Massive seg (int b) {
        if (b == 0) {
            throw new RuntimeException("ERR");
        }
        else {
            for (int i = 0; i < this.getSize();i++) {
                int newelement = this.getEl(i)/b;
                this.setEl(newelement,i);
            }
        }
        return this;
    }

    public String toString () {
        String s = "";
        for (int i = 0; i < this.getSize(); i++){
            s += this.getEl(i) + ",";
        }
        return "(" + s + ")";
    }


}