package io.github.jhipster.demo.talkorganizer.ui;

import java.util.List;

import org.eclipse.scout.boot.ui.commons.fonts.FontAwesomeIcons;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.Bean;
import org.eclipse.scout.rt.shared.TEXTS;

import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceTablePage;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationTablePage;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerTablePage;
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkTablePage;

@Bean
public class EntitiesOutline extends AbstractOutline {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Entities");
  }

  @Override
  protected String getConfiguredIconId() {
    return FontAwesomeIcons.fa_folder;
  }

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    pageList.add(new ConferenceTablePage());
    pageList.add(new LocationTablePage());
    pageList.add(new SpeakerTablePage());
    pageList.add(new TalkTablePage());
  }
}
