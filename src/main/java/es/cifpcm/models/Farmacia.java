package es.cifpcm.models;

public class Farmacia {
    private String WEB;
    private String LUNES;
    private String MARTES;
    private String MIERCOLES;
    private String JUEVES;
    private String VIERNES;
    private String SABADO;
    private String DOMINGO;
    private int TELEFONO;
    private String NOMBRE;
    private float UTM_X;
    private float UTM_Y;

    public Farmacia(String WEB, String LUNES, String MARTES, String MIERCOLES, String JUEVES, String VIERNES, String SABADO, String DOMINGO, int TELEFONO, String NOMBRE, float UTM_X, float UTM_Y) {
        this.WEB = WEB;
        this.LUNES = LUNES;
        this.MARTES = MARTES;
        this.MIERCOLES = MIERCOLES;
        this.JUEVES = JUEVES;
        this.VIERNES = VIERNES;
        this.SABADO = SABADO;
        this.DOMINGO = DOMINGO;
        this.TELEFONO = TELEFONO;
        this.NOMBRE = NOMBRE;
        this.UTM_X = UTM_X;
        this.UTM_Y = UTM_Y;
    }

    public String getWEB() {
        return WEB;
    }

    public void setWEB(String WEB) {
        this.WEB = WEB;
    }

    public String getLUNES() {
        return LUNES;
    }

    public void setLUNES(String LUNES) {
        this.LUNES = LUNES;
    }

    public String getMARTES() {
        return MARTES;
    }

    public void setMARTES(String MARTES) {
        this.MARTES = MARTES;
    }

    public String getMIERCOLES() {
        return MIERCOLES;
    }

    public void setMIERCOLES(String MIERCOLES) {
        this.MIERCOLES = MIERCOLES;
    }

    public String getJUEVES() {
        return JUEVES;
    }

    public void setJUEVES(String JUEVES) {
        this.JUEVES = JUEVES;
    }

    public String getVIERNES() {
        return VIERNES;
    }

    public void setVIERNES(String VIERNES) {
        this.VIERNES = VIERNES;
    }

    public String getSABADO() {
        return SABADO;
    }

    public void setSABADO(String SABADO) {
        this.SABADO = SABADO;
    }

    public String getDOMINGO() {
        return DOMINGO;
    }

    public void setDOMINGO(String DOMINGO) {
        this.DOMINGO = DOMINGO;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public float getUTM_X() {
        return UTM_X;
    }

    public void setUTM_X(float UTM_X) {
        this.UTM_X = UTM_X;
    }

    public float getUTM_Y() {
        return UTM_Y;
    }

    public void setUTM_Y(float UTM_Y) {
        this.UTM_Y = UTM_Y;
    }
}


