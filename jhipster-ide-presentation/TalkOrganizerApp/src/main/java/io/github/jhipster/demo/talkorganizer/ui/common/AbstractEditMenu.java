package io.github.jhipster.demo.talkorganizer.ui.common;

import org.eclipse.scout.boot.ui.commons.fonts.FontAwesomeIcons;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.shared.TEXTS;

public class AbstractEditMenu extends AbstractMenu {

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("Edit");
  }

  @Override
  protected String getConfiguredIconId() {
    return FontAwesomeIcons.fa_pencil;
  }

  @Override
  protected String getConfiguredKeyStroke() {
    return "alt-e";
  }
}
