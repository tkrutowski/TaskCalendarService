package net.focik.taskcalendar.domain.share;

//TODO jak się da to zmienić na PL
public enum GasCabinetProviderType {
    UNKNOW("Nieznane"),
    CUSTOMER("Klient"),
    PSG("PSG"),
    COMPANY("Progas");

    private String dbValue;

    GasCabinetProviderType(String dbValue) {
        this.dbValue = dbValue;
    }
}
