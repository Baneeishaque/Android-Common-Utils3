package ndk.utils_android1;

public abstract class ApiUtilsWithFileExtension1 {

    public String getApiMethodEndpointUrl(String apiMethodName) {

        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + apiMethodName + getFileExtension();
    }

    protected abstract String getFileExtension();

    protected abstract String getServerApplicationFolder();

    protected abstract String getServerAddress();

    protected abstract String getAddressProtocol();
}
