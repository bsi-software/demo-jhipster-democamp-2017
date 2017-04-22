package io.github.jhipster.demo.talkorganizer.ui;

import org.eclipse.scout.rt.shared.services.common.text.AbstractDynamicNlsTextProviderService;

public class TextProviderService extends AbstractDynamicNlsTextProviderService {

  @Override
  public String getDynamicNlsBaseName() {
    return "io.github.jhipster.demo.talkorganizer.texts.Texts";
  }
}
