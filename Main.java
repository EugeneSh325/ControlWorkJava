import java.util.*;

public class Main {
    private static Set<Notebook> notebooks = new HashSet<>();

    private static Map<String, String> parameters = new HashMap<>();

    public static void main(String[] args) {
        initialize();
        fillParameters();
        findNotebooks();
    }

    private static void initialize() {
        notebooks.add(new Notebook("Lenovo", "IdeaPad 1 15IGL7 82V700EMUE", "Intel Celeron N4020", 2, 2.8, 8, "Intel UHD Graphics", 0, 256, 15.6, null, "серый"));
        notebooks.add(new Notebook("HP", "250 G9 6S798EA", "Intel Celeron N4500", 2, 2.8, 8, "Intel UHD Graphics", 0, 256, 15.6, "Free DOS", "темно-серебристый"));
        notebooks.add(new Notebook("Acer", "Aspire 3 A315-23-R5HA NX.HVTER.01D", "AMD Ryzen 3 3250U", 2, 3.5, 8, "AMD Ryzen 3 3250U", 0, 128, 15.6, null, "чёрный"));
        notebooks.add(new Notebook("ASUS", "Vivobook Go E1504GA-BQ150 90NB0ZT2-M00600", "Intel N200", 4, 3.7, 8, "Intel UHD Graphics", 0, 256, 15.6, null, "чёрный"));
        notebooks.add(new Notebook("DELL", "Vostro 3520 3520-3821", "Intel Core i3 1215U", 6, 4.4, 8, "Intel UHD Graphics", 0, 256, 15.6, "Windows 11 Home", "чёрный"));
        notebooks.add(new Notebook("MSI", "Modern 14 C12MO-1086XRU 9S7-14J111-1086", "Intel Core i3 1215U", 6, 4.4, 16, "Intel UHD Graphics", 0, 512, 14, "Free DOS", "серебристый"));
        notebooks.add(new Notebook("Xiaomi", "RedmiBook 15E XMA2101-BN", "Intel Core i7 11390H", 4, 5, 16, "Intel Iris Xe graphics", 0, 512, 15.6, "Windows 11 Trial", "чёрный"));
        notebooks.add(new Notebook("Samsung", "Galaxy Book 2 NP754 NP754XED-KC4IT", "Intel Core i5 1235U", 10, 4.4, 16, "Intel Iris Xe graphics", 0, 256, 15.6, "Windows 11 Professional", "серебристый"));
        notebooks.add(new Notebook("Xiaomi", "RedmiBook JYU4575CN", "Intel Core i5 13500H", 12, 4.7, 16, "Intel Iris Xe graphics", 0, 1024, 14, "Windows 11 Trial", "серый"));
        notebooks.add(new Notebook("DELL", "Vostro 3520 3520-W702", "Intel Core i7 1255U", 10, 4.7, 16, "Intel Iris Xe graphics", 0, 512, 15.6, "Windows 11 Professional", "чёрный"));
        notebooks.add(new Notebook("Samsung", "Galaxy Book 3 Pro NP944 NP944XFG-KC1IT", "Intel Core i7 1360P", 12, 5, 16, "Intel Iris Xe graphics", 0, 512, 14, "Windows 11 Professional", "графитовый"));
        notebooks.add(new Notebook("Acer", "Nitro 17 AN17-41-R3S4 NH.QKNCD.002", "AMD Ryzen 9 7940HS", 8, 5.2, 32, "NVIDIA GeForce RTX 4070", 8, 1024, 17.3, null, "чёрный"));
        notebooks.add(new Notebook("HP", "Spectre x360 16-f1022nn 7N7G2EA 7N7G2EA", "Intel Core i7 1260P", 12, 4.7, 16, "Intel Arc A370M", 4, 1024, 16, "Windows 11 Home", "чёрный"));
        notebooks.add(new Notebook("ASUS", "Zenbook Pro 16X OLED UX7602VI-MY073X 90NB10K1-M00430", "Intel Core i9 13900H", 14, 5.4, 32, "NVIDIA GeForce RTX 4070", 8, 2048, 16, "Windows 11 Professional", "чёрный"));
        notebooks.add(new Notebook("Lenovo", "ThinkPad P16 G2 21FBA06GCD", "Intel Core i7 13700HX", 16, 5, 16, "NVIDIA RTX A1000", 6, 1024, 16, "Windows 11 Professional", "чёрный"));
        notebooks.add(new Notebook("MSI", "Titan 18 HX A14VIG-211RU 9S7-182221-211", "Intel Core i9 14900HX", 24, 5.6, 64, "NVIDIA GeForce RTX 4090", 16, 1024, 18, "Windows 11 Home", "чёрный"));
    }

    public static void fillParameters() {
        parameters.clear();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Наименование производителя: ");
        parameters.put("vendor", scanner.nextLine());
        System.out.print("Модель ноутбука: ");
        parameters.put("model", scanner.nextLine());
        System.out.print("Производитель процессора (0 - любой, 1 - Intel, 2 - AMD): ");
        switch (scanner.nextInt()) {
            case 0:
                parameters.put("cpuName", "");
                break;
            case 1:
                parameters.put("cpuName", "Intel");
                break;
            case 2:
                parameters.put("cpuName", "AMD");
                break;
        }
        System.out.print("Минимальное количество ядер процессора: ");
        parameters.put("cpuCoreCount", String.valueOf(scanner.nextInt()));
        System.out.print("Минимальная частота процессора, ГГц: ");
        parameters.put("cpuFrequency", String.valueOf(scanner.nextDouble()));
        System.out.print("Минимальный объём оперативной памяти, Гб: ");
        parameters.put("systemMemory", String.valueOf(scanner.nextInt()));
        System.out.print("Минимальный объём видеопамяти, Гб: ");
        parameters.put("videoCardMemory", String.valueOf(scanner.nextInt()));
        System.out.print("Минимальный объём SSD, Гб: ");
        parameters.put("ssdVolume", String.valueOf(scanner.nextInt()));
        System.out.print("Минимальную диагональ экрана, дюймов: ");
        parameters.put("screenSize", String.valueOf(scanner.nextDouble()));
        System.out.print("Операционная система (0 - без ОС, 1 - Windows, 2 - Free DOS, 3 - любая): ");
        switch (scanner.nextInt()) {
            case 0:
                parameters.put("operatingSystem", null);
                break;
            case 1:
                parameters.put("operatingSystem", "Windows");
                break;
            case 2:
                parameters.put("operatingSystem", "Free DOS");
                break;
            case 3:
                parameters.put("operatingSystem", "");
                break;
        }
        scanner.nextLine();
        System.out.print("Введите цвет: ");
        parameters.put("color", scanner.nextLine());
    }

    public static void findNotebooks() {
        int count = 0;
        boolean notebookEquals;
        String vendor = parameters.get("vendor").toLowerCase();
        String model = parameters.get("model").toLowerCase();
        String cpuName = parameters.get("cpuName").toLowerCase();
        int cpuCoreCount = Integer.parseInt(parameters.get("cpuCoreCount"));
        double cpuFrequency = Double.parseDouble(parameters.get("cpuFrequency"));
        int systemMemory = Integer.parseInt(parameters.get("systemMemory"));
        int videoCardMemory = Integer.parseInt(parameters.get("videoCardMemory"));
        int ssdVolume = Integer.parseInt(parameters.get("ssdVolume"));
        double screenSize = Double.parseDouble(parameters.get("screenSize"));
        String operatingSystem = parameters.get("operatingSystem");
        String color = parameters.get("color").toLowerCase();
        System.out.println("\nРезультаты поиска:");
        for (Notebook notebook : notebooks) {
            notebookEquals = vendor.isEmpty() || notebook.getVendor().equalsIgnoreCase(vendor);
            notebookEquals &= model.isEmpty() || notebook.getModel().toLowerCase().contains(model.toLowerCase());
            notebookEquals &= cpuName.isEmpty() || notebook.getCpuName().toLowerCase().contains(cpuName.toLowerCase());
            notebookEquals &= notebook.getCpuCoreCount() >= cpuCoreCount;
            notebookEquals &= notebook.getCpuFrequency() >= cpuFrequency;
            notebookEquals &= notebook.getSystemMemory() >= systemMemory;
            notebookEquals &= notebook.getVideoCardMemory() >= videoCardMemory;
            notebookEquals &= notebook.getSsdVolume() >= ssdVolume;
            notebookEquals &= notebook.getScreenSize() >= screenSize;
            notebookEquals &= (operatingSystem != null && operatingSystem.isEmpty()) ||
                    (operatingSystem == null && notebook.getOperatingSystem() == null) ||
                    (operatingSystem != null && notebook.getOperatingSystem() != null &&
                            notebook.getOperatingSystem().toLowerCase().contains(operatingSystem.toLowerCase()));
            notebookEquals &= color.isEmpty() || notebook.getColor().equalsIgnoreCase(color);
            if (notebookEquals) {
                System.out.println(notebook);
                count++;
            }
        }
        System.out.printf("\nНайдено ноутбуков: " + count);
    }
