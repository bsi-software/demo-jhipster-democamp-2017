package io.github.jhipster.demo.talkorganizer.ui.conference;

import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractDateColumn;
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
import io.github.jhipster.demo.talkorganizer.ui.conference.ConferenceTablePage.Table;

public class ConferenceTablePage extends AbstractPageWithTable<Table> {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Conferences");
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
//TODO implement load-data and binding
//    importPageData(BEANS.get(IConferenceService.class).getConferenceTableData(filter));
  }

  public class Table extends AbstractTable {

    public DateColumn getDateColumn() {
      return getColumnSet().getColumnByClass(DateColumn.class);
    }

    public TitleColumn getTitleColumn() {
      return getColumnSet().getColumnByClass(TitleColumn.class);
    }

    public ConferenceIdColumn getConferenceIdColumn() {
      return getColumnSet().getColumnByClass(ConferenceIdColumn.class);
    }

    @Order(1000)
    public class ConferenceIdColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("ConferenceId");
      }

      @Override
      protected int getConfiguredWidth() {
        return 150;
      }
    }

    @Order(2000)
    public class TitleColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Title");
      }

      @Override
      protected int getConfiguredWidth() {
        return 300;
      }
    }

    @Order(3000)
    public class DateColumn extends AbstractDateColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Date");
      }

      @Override
      protected int getConfiguredWidth() {
        return 200;
      }
    }

    @Order(1000)
    public class EditConferenceMenu extends AbstractEditMenu {

      @Override
      protected void execAction() {
        final ConferenceForm form = new ConferenceForm();
        form.getConferenceIdField().setValue(getConferenceIdColumn().getSelectedValue());
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
        final ConferenceForm form = new ConferenceForm();
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
