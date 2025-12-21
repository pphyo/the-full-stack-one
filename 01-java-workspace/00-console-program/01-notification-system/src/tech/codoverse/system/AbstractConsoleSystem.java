package tech.codoverse.system;

public abstract class AbstractConsoleSystem {

    private String appName;
    private AbstractFeature[] features;

    public AbstractConsoleSystem(String appName, AbstractFeature[] features) {
        this.appName = appName;
        this.features = features;
    }

    public String getAppName() {
        return appName;
    }

    public abstract void launch();

    public AbstractFeature getSelectedFeature() {
        IO.println();

        for (var feature : features) {
            feature.showMenu();
        }
        IO.println();

        var selectedId = Integer.parseInt(IO.readln("Choose ID: "));
        return features[selectedId - 1];
    }

}
