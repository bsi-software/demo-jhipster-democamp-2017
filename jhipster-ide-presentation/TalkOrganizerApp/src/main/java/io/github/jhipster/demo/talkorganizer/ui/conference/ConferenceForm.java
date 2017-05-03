package io.github.jhipster.demo.talkorganizer.ui.conference;

import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.longfield.AbstractLongField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.wizard.DefaultWizardContainerForm.MainBox.ContentBox;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.shared.TEXTS;

import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceForm.MainBox.CancelButton;
import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceForm.MainBox.ContentBox.ConferenceIdField;
import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceForm.MainBox.ContentBox.DateField;
import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceForm.MainBox.ContentBox.TitleField;
import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceForm.MainBox.OkButton;

public class ConferenceForm extends AbstractForm {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Conference");
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

  public ContentBox getContentBox() {
    return getFieldByClass(ContentBox.class);
  }

  public ConferenceIdField getConferenceIdField() {
    return getFieldByClass(ConferenceIdField.class);
  }

  public TitleField getTitleField() {
    return getFieldByClass(TitleField.class);
  }

  public DateField getDateField() {
    return getFieldByClass(DateField.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(1000)
  public class MainBox extends AbstractGroupBox {

    @Order(1000)
    public class ContentBox extends AbstractGroupBox {
      @Order(100000)
      public class ConferenceIdField extends AbstractLongField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ConferenceId");
        }

        @Override
        protected boolean getConfiguredEnabled() {
          return false;
        }
      }

      @Order(101000)
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

      @Order(102000)
      public class DateField extends AbstractDateField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Date");
        }
      }

      // TODO list talks in a table.
    }

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
//      IConferenceService service = BEANS.get(IConferenceService.class);
//      ConferenceFormData formData = new ConferenceFormData();
//      exportFormData(formData);
//      formData = service.load(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new UpdateConferencePermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      IConferenceService service = BEANS.get(IConferenceService.class);
//      ConferenceFormData formData = new ConferenceFormData();
//      exportFormData(formData);
//      service.store(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() {
//TODO implement data-load and binding
//      IConferenceService service = BEANS.get(IConferenceService.class);
//      ConferenceFormData formData = new ConferenceFormData();
//      exportFormData(formData);
//      formData = service.prepareCreate(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new CreateConferencePermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      IConferenceService service = BEANS.get(IConferenceService.class);
//      ConferenceFormData formData = new ConferenceFormData();
//      exportFormData(formData);
//      service.create(formData);
    }
  }
}
