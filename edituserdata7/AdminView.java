import java.util.ArrayList;

public class AdminView {

    public void AdminMenu1Frame(DLSU_SRSAdmin_controller Acontroller) {
        new AdminMenu1Frame(Acontroller);
    }
    
    public void AdminEditUserData(DLSU_SRSAdmin_controller Acontroller, int userId) {
        new AdminEditUserData(Acontroller, userId);
    }

    public void ShuttleRouteMenu(DLSU_SRSAdmin_controller Acontroller) {
        new ShuttleRouteMenu(Acontroller);
    }

    public void ADMINSRSFRAME_VIEWSHUTTLEROUTES(DLSU_SRSAdmin_controller Acontroller, ArrayList<ShuttleRoute> shuttleRoutes) {
        new ADMINSRSFRAME_VIEWSHUTTLEROUTES(Acontroller, shuttleRoutes);
    }
/*
    public void ADMINSRSFRAME_EDITSHUTTLEROUTES() {
        new ADMINSRSFRAME_EDITSHUTTLEROUTES();
    }
*/
}
