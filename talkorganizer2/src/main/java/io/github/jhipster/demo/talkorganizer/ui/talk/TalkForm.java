package io.github.jhipster.demo.talkorganizer.ui.talk;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.shared.TEXTS;

import io.github.jhipster.demo.talkorganizer.ui.talk.TalkForm.MainBox.CancelButton;
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkForm.MainBox.DescriptionField;
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkForm.MainBox.OkButton;
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkForm.MainBox.TalkIdField;
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkForm.MainBox.TitleField;

public class TalkForm extends AbstractForm {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Talk");
  }

  @Override
  protected int getConfiguredDisplayHint() {
    return IForm.DISPLAY_HINT_VIEW;
  }

  public void startModify() {
    startInternalExclusive(new ModifyHandler());
  }

  public void startNew() {
    startInternal(new NewHandler());
  }

  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public TalkIdField getTalkIdField() {
    return getFieldByClass(TalkIdField.class);
  }

  public TitleField getTitleField() {
    return getFieldByClass(TitleField.class);
  }

  public DescriptionField getDescriptionField() {
    return getFieldByClass(DescriptionField.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(1000)
  public class MainBox extends AbstractGroupBox {

    @Order(1000)
    public class TalkIdField extends AbstractLongField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("TalkId");
      }
    }

    @Order(2000)
    public class TitleField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Title");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }
    }

    @Order(3000)
    public class DescriptionField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Description");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }

      @Override
      protected boolean getConfiguredMultilineText() {
        return true;
      }

      @Override
      protected int getConfiguredGridH() {
        return 3;
      }

      @Override
      protected int getConfiguredGridW() {
        return 2;
      }

    }

    //TODO add speakers

    @Order(100000)
    public class OkButton extends AbstractOkButton {
    }

    @Order(101000)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() {
//TODO implement data-load and binding
//      ITalkService service = BEANS.get(ITalkService.class);
//      TalkFormData formData = new TalkFormData();
//      exportFormData(formData);
//      formData = service.load(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new UpdateTalkPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ITalkService service = BEANS.get(ITalkService.class);
//      TalkFormData formData = new TalkFormData();
//      exportFormData(formData);
//      service.store(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() {
//TODO implement data-load and binding
//      ITalkService service = BEANS.get(ITalkService.class);
//      TalkFormData formData = new TalkFormData();
//      exportFormData(formData);
//      formData = service.prepareCreate(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new CreateTalkPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ITalkService service = BEANS.get(ITalkService.class);
//      TalkFormData formData = new TalkFormData();
//      exportFormData(formData);
//      service.create(formData);
    }
  }
}
