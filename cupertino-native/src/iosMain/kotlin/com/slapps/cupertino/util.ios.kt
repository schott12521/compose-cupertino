

package com.slapps.cupertino

import platform.UIKit.UIUserInterfaceStyle
import platform.UIKit.UIView
import platform.UIKit.UIViewController

internal fun UIViewController.applyTheme(dark: Boolean) {
    overrideUserInterfaceStyle = if (dark)
        UIUserInterfaceStyle.UIUserInterfaceStyleDark
    else UIUserInterfaceStyle.UIUserInterfaceStyleLight
}

internal fun UIView.applyTheme(dark : Boolean){
    listOf(this, superview).forEach {
        it?.overrideUserInterfaceStyle = if (dark)
            UIUserInterfaceStyle.UIUserInterfaceStyleDark
        else UIUserInterfaceStyle.UIUserInterfaceStyleLight
    }
}
