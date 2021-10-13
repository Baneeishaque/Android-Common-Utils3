package ndk.utils_android1;

public abstract class ApiUtilsWithHttpApiFolderAndFileExtension1 {

    public String getApiMethodEndpointUrl(String apiMethodName) {

        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + getServerApplicationHttpApiFolder() + "/" + apiMethodName + getFileExtension();
    }

    public String getImageUrl(String imageFolderUnderServerApplicationFolder, String imageNameWithExtension) {

        return getAddressProtocol() + "://" + getServerAddress() + "/" + getServerApplicationFolder() + "/" + imageFolderUnderServerApplicationFolder + "/" + imageNameWithExtension;
    }

    public String getPngImageUrl(String imageFolderUnderServerApplicationFolder, String imageName) {

        return getImageUrl(imageFolderUnderServerApplicationFolder, imageName + ".png");
    }

    protected abstract String getServerApplicationHttpApiFolder();

    protected abstract String getFileExtension();

    protected abstract String getServerApplicationFolder();

    protected abstract String getServerAddress();

    protected abstract String getAddressProtocol();
}
