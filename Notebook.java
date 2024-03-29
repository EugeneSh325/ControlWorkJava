import java.util.Objects;

public class Notebook {
    private String vendor;
    private String model;
    private String cpuName;
    private int cpuCoreCount;
    private double cpuFrequency;
    private int systemMemory;
    private String videoCardName;
    private int videoCardMemory;
    private int ssdVolume;
    private double screenSize;
    private String operatingSystem;
    private String color;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nНаименование: ").append(vendor).append(" ").append(model);
        stringBuilder.append("\nДиагональ экрана: ").append(screenSize).append("\"");
        stringBuilder.append("\nПроцессор: ").append(cpuName).append(" (").append(cpuCoreCount).append(" X ")
                .append(cpuFrequency).append(" ГГц)");
        stringBuilder.append("\nОперативная память: ").append(systemMemory).append(" Гб");
        stringBuilder.append("\nВидеокарта: ").append(videoCardName);
        if (videoCardMemory > 0) {
            stringBuilder.append("\nОбъём видеопамяти: ").append(videoCardMemory).append(" Гб");
        }
        stringBuilder.append("\nОбъём SSD: ").append(ssdVolume).append(" Гб");
        stringBuilder.append("\nОперационная система: ").append(operatingSystem == null
                ? "отсутствует" : operatingSystem);
        stringBuilder.append("\nЦвет: ").append(color);
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return Objects.equals(vendor, notebook.vendor) && Objects.equals(model, notebook.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor, model);
    }

    public Notebook(String vendor, String model, String cpuName, int cpuCoreCount, double cpuFrequency,
                    int systemMemory, String videoCardName, int videoCardMemory, int ssdVolume, double screenSize,
                    String operatingSystem, String color) {
        this.vendor = vendor;
        this.model = model;
        this.cpuName = cpuName;
        this.cpuCoreCount = cpuCoreCount;
        this.cpuFrequency = cpuFrequency;
        this.systemMemory = systemMemory;
        this.videoCardName = videoCardName;
        this.videoCardMemory = videoCardMemory;
        this.ssdVolume = ssdVolume;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getCpuName() {
        return cpuName;
    }

    public int getCpuCoreCount() {
        return cpuCoreCount;
    }

    public double getCpuFrequency() {
        return cpuFrequency;
    }

    public int getSystemMemory() {
        return systemMemory;
    }

    public String getVideoCardName() {
        return videoCardName;
    }

    public int getVideoCardMemory() {
        return videoCardMemory;
    }

    public int getSsdVolume() {
        return ssdVolume;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}
