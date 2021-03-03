package fr.dwightstudio.dsmapi;

import fr.dwightstudio.dsmapi.pages.Page;

/**
 * A simple menu with an single page.
 */
public abstract class SimpleMenu extends Menu implements Page {

    @Override
    public int getPageCount() {
        return 1;
    }

    @Override
    public Page getPage(int index) {
        return this;
    }

    @Override
    public Page[] getPages() {
        return new Page[] {this};
    }
}
