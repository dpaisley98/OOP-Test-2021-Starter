package ie.tudublin;


public class Note {
    private char note;
    private int duration;
    private float c;

    
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
        this. c = 0;
    }

    public char getNote() {
        return note;
    }


    public void setNote(char note) {
        this.note = note;
    }


    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + "]";
    }
    
}
