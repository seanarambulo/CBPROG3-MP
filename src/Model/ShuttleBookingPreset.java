package src.Model;

public class ShuttleBookingPreset extends ShuttleBookingView {
    
    private int presetID;

    public ShuttleBookingPreset(int presetID){
        this.presetID = presetID;
    }

    public ShuttleBookingPreset(int presetID, String Origin, String Destination, String arrowsExpressLine, String time){
        super(Origin, Destination, arrowsExpressLine, time);
        this.presetID = presetID;
    }

    public void setPresetID(int presetID){
        this.presetID = presetID;
    }

    public int getPresetID() {
        return presetID;
    }
    
}
