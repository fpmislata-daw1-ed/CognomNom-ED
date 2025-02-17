package exam2;

public class Lamp {
    private final double consumption; // In kWh
    private boolean on;

    public Lamp(double consumption) {
        this.consumption = consumption;
        this.on = false;
    }

    public Lamp(double consumption, boolean on) {
        this.consumption = consumption;
        this.on = on;
    }

    public double getConsumption() {
        return this.consumption;
    }

    public boolean isOn() {
        return this.on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void toggle() {
        this.on = !this.on;
    }

    public double consume(double seconds) {
        if (this.on)
            return this.consumption * seconds / 3600.0;
        return 0;
    }
}
