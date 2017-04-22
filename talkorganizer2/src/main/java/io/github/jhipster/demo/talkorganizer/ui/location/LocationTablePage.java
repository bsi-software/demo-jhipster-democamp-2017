package io.github.jhipster.demo.talkorganizer.ui.location;

import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractLongColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.form.FormEvent;
import org.eclipse.scout.rt.client.ui.form.FormListener;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

import io.github.jhipster.demo.talkorganizer.ui.common.AbstractEditMenu;
import io.github.jhipster.demo.talkorganizer.ui.common.AbstractNewMenu;
import io.github.jhipster.demo.talkorganizer.ui.location.LocationTablePage.Table;

public class LocationTablePage extends AbstractPageWithTable<Table> {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Locations");
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
//TODO implement load-data and binding
//    importPageData(BEANS.get(ILocationService.class).getLocationTableData(filter));
  }

  public class Table extends AbstractTable {

    public CityColumn getCityColumn() {
      return getColumnSet().getColumnByClass(CityColumn.class);
    }

    public StateProvinceColumn getStateProvinceColumn() {
      return getColumnSet().getColumnByClass(StateProvinceColumn.class);
    }

    public CountryNameColumn getCountryNameColumn() {
      return getColumnSet().getColumnByClass(CountryNameColumn.class);
    }

    public PostalCodeColumn getPostalCodeColumn() {
      return getColumnSet().getColumnByClass(PostalCodeColumn.class);
    }

    public StreetAddressColumn getStreetAddressColumn() {
      return getColumnSet().getColumnByClass(StreetAddressColumn.class);
    }

    public LocationIdColumn getLocationIdColumn() {
      return getColumnSet().getColumnByClass(LocationIdColumn.class);
    }

    @Order(1000)
    public class LocationIdColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("LocationId");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(2000)
    public class StreetAddressColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("StreetAddress");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(3000)
    public class PostalCodeColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("PostalCode");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(4000)
    public class CityColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("City");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(5000)
    public class StateProvinceColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("StateProvince");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(6000)
    public class CountryNameColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("CountryName");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(1000)
    public class EditLocationMenu extends AbstractEditMenu {

      @Override
      protected void execAction() {
        final LocationForm form = new LocationForm();
        form.getLocationIdField().setValue(getLocationIdColumn().getSelectedValue());
        form.addFormListener(new FormListener() {

          @Override
          public void formChanged(FormEvent e) {
            if (FormEvent.TYPE_CLOSED == e.getType() && form.isFormStored()) {
              reloadPage();
            }
          }
        });

        form.startModify();
      }
    }

    @Order(2000)
    public class NewMenu extends AbstractNewMenu {

      @Override
      protected void execAction() {
        final LocationForm form = new LocationForm();
        form.addFormListener(new FormListener() {

          @Override
          public void formChanged(FormEvent e) {
            if (FormEvent.TYPE_CLOSED == e.getType() && form.isFormStored()) {
              reloadPage();
            }
          }
        });

        form.startNew();
      }
    }
  }
}
