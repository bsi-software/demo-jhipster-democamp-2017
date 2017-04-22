package io.github.jhipster.demo.talkorganizer.ui.location;

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

import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.CancelButton;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.CityField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.CountryNameField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.LocationIdField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.PostalCodeField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.StateProvinceField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.ContentBox.StreetAddressField;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationForm.MainBox.OkButton;

public class LocationForm extends AbstractForm {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Location");
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

  public LocationIdField getLocationIdField() {
    return getFieldByClass(LocationIdField.class);
  }

  public StreetAddressField getStreetAddressField() {
    return getFieldByClass(StreetAddressField.class);
  }

  public PostalCodeField getPostalCodeField() {
    return getFieldByClass(PostalCodeField.class);
  }

  public CityField getCityField() {
    return getFieldByClass(CityField.class);
  }

  public StateProvinceField getStateProvinceField() {
    return getFieldByClass(StateProvinceField.class);
  }

  public CountryNameField getCountryNameField() {
    return getFieldByClass(CountryNameField.class);
  }

  public ContentBox getContentBox() {
    return getFieldByClass(ContentBox.class);
  }

  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(1000)
  public class MainBox extends AbstractGroupBox {

    @Order(0)
    public class ContentBox extends AbstractGroupBox {

      @Order(1000)
      public class LocationIdField extends AbstractLongField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LocationId");
        }
      }

      @Order(2000)
      public class StreetAddressField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StreetAddress");
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 128;
        }
      }

      @Order(3000)
      public class PostalCodeField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("PostalCode");
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 128;
        }
      }

      @Order(4000)
      public class CityField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("City");
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 128;
        }
      }

      @Order(5000)
      public class StateProvinceField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("StateProvince");
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 128;
        }
      }

      @Order(6000)
      public class CountryNameField extends AbstractStringField {
        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("CountryName");
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 128;
        }
      }
      //TODO link conference?
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
//      ILocationService service = BEANS.get(ILocationService.class);
//      LocationFormData formData = new LocationFormData();
//      exportFormData(formData);
//      formData = service.load(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new UpdateLocationPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ILocationService service = BEANS.get(ILocationService.class);
//      LocationFormData formData = new LocationFormData();
//      exportFormData(formData);
//      service.store(formData);
    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() {
//TODO implement data-load and binding
//      ILocationService service = BEANS.get(ILocationService.class);
//      LocationFormData formData = new LocationFormData();
//      exportFormData(formData);
//      formData = service.prepareCreate(formData);
//      importFormData(formData);
//
//      setEnabledPermission(new CreateLocationPermission());
    }

    @Override
    protected void execStore() {
//TODO implement data-store and binding
//      ILocationService service = BEANS.get(ILocationService.class);
//      LocationFormData formData = new LocationFormData();
//      exportFormData(formData);
//      service.create(formData);
    }
  }
}
