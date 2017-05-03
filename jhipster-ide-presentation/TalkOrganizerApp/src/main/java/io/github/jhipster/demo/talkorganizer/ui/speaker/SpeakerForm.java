package io.github.jhipster.demo.talkorganizer.ui.speaker;

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

import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.CancelButton;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.EmailField;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.FirstNameField;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.LastNameField;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.OkButton;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.PhoneNumberField;
import io.github.jhipster.demo.talkorganizer.ui.speaker.SpeakerForm.MainBox.SpeakerIdField;

public class SpeakerForm extends AbstractForm {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Speaker");
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

  public SpeakerIdField getSpeakerIdField() {
    return getFieldByClass(SpeakerIdField.class);
  }

  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  public LastNameField getLastNameField() {
    return getFieldByClass(LastNameField.class);
  }

  public EmailField getEmailField() {
    return getFieldByClass(EmailField.class);
  }

  public PhoneNumberField getPhoneNumberField() {
    return getFieldByClass(PhoneNumberField.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(1000)
  public class MainBox extends AbstractGroupBox {

    @Order(1000)
    public class SpeakerIdField extends AbstractLongField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("SpeakerId");
      }

      @Override
      protected boolean getConfiguredEnabled() {
        return false;
      }
    }

    @Order(2000)
    public class FirstNameField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("FirstName");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }
    }

    @Order(3000)
    public class LastNameField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("LastName");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }
    }

    @Order(4000)
    public class EmailField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("Email");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }
    }

    @Order(5000)
    public class PhoneNumberField extends AbstractStringField {
      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("PhoneNumber");
      }

      @Override
      protected int getConfiguredMaxLength() {
        return 128;
      }
    }

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
//      ISpeakerService service = BEANS.get(ISpeakerService.class);
//      SpeakerFormData formData = new SpeakerFormData();
//      exportFormData(formData);
//      formData = service.load(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new UpdateSpeakerPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ISpeakerService service = BEANS.get(ISpeakerService.class);
//      SpeakerFormData formData = new SpeakerFormData();
//      exportFormData(formData);
//      service.store(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() {
//TODO implement data-load and binding
//      ISpeakerService service = BEANS.get(ISpeakerService.class);
//      SpeakerFormData formData = new SpeakerFormData();
//      exportFormData(formData);
//      formData = service.prepareCreate(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new CreateSpeakerPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ISpeakerService service = BEANS.get(ISpeakerService.class);
//      SpeakerFormData formData = new SpeakerFormData();
//      exportFormData(formData);
//      service.create(formData);
    }
  }
}
