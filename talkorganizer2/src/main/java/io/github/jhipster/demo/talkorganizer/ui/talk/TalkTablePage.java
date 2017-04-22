package io.github.jhipster.demo.talkorganizer.ui.talk;

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
import io.github.jhipster.demo.talkorganizer.ui.talk.TalkTablePage.Table;

public class TalkTablePage extends AbstractPageWithTable<Table> {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Talks");
  }

  @Override
  protected void execLoadData(SearchFilter filter) {
//TODO implement load-data and binding
//    importPageData(BEANS.get(ITalkService.class).getTalkTableData(filter));
  }

  public class Table extends AbstractTable {

    public TitleColumn getTitleColumn() {
      return getColumnSet().getColumnByClass(TitleColumn.class);
    }

    public DescriptionColumn getDescriptionColumn() {
      return getColumnSet().getColumnByClass(DescriptionColumn.class);
    }

    public TalkIdColumn getTalkIdColumn() {
      return getColumnSet().getColumnByClass(TalkIdColumn.class);
    }

    @Order(1000)
    public class TalkIdColumn extends AbstractLongColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("TalkId");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
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
    public class DescriptionColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Description");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(1000)
    public class EditTalkMenu extends AbstractEditMenu {

      @Override
      protected void execAction() {
        final TalkForm form = new TalkForm();
        form.getTalkIdField().setValue(getTalkIdColumn().getSelectedValue());
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
        final TalkForm form = new TalkForm();
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
