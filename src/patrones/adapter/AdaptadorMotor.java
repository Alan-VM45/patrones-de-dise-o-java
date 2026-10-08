package patrones.adapter;

import java.util.Objects;

public final class AdaptadorMotor implements Motor {
    private final MotorViejo motorViejo;
    public AdaptadorMotor(MotorViejo motorViejo) {
        this.motorViejo = Objects.requireNonNull(motorViejo, "motorViejo");
    }
    @Override
    public String conectar() { return motorViejo.encenderConLlave(); }
}