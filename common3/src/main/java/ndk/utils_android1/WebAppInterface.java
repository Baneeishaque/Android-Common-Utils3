package ndk.utils_android1;

import android.webkit.JavascriptInterface;

public class WebAppInterface {

    private WebAppInterfaceFurtherActions webAppInterfaceFurtherActions;

    /**
     * Instantiate the interface and set the context
     *
     * @param webAppInterfaceFurtherActions FurtherActions interface instance
     */
    public WebAppInterface(WebAppInterfaceFurtherActions webAppInterfaceFurtherActions) {

        this.webAppInterfaceFurtherActions = webAppInterfaceFurtherActions;
    }

    @JavascriptInterface
    public void doActions() {
        webAppInterfaceFurtherActions.doActions();
    }
}
