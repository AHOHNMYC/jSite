/*
 * jSite - PreferencesPage.java -
 * Copyright © 2009 David Roden
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package de.todesbaum.jsite.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

import de.todesbaum.jsite.i18n.I18n;
import de.todesbaum.jsite.i18n.I18nContainer;
import de.todesbaum.util.swing.TWizard;
import de.todesbaum.util.swing.TWizardPage;

/**
 * Page that shows some preferences that are valid for the complete application.
 *
 * @author David ‘Bombe’ Roden &lt;bombe@freenetproject.org&gt;
 */
public class PreferencesPage extends TWizardPage {

	/** Action that chooses a new temp directory. */
	private Action chooseTempDirectoryAction;

	/**
	 * Creates a new “preferences” page.
	 *
	 * @param wizard
	 *            The wizard this page belongs to
	 */
	public PreferencesPage(TWizard wizard) {
		super(wizard);
		pageInit();
		setHeading(I18n.getMessage("jsite.preferences.heading"));
		setDescription(I18n.getMessage("jsite.preferences.description"));
		I18nContainer.getInstance().registerRunnable(new Runnable() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void run() {
				setHeading(I18n.getMessage("jsite.preferences.heading"));
				setDescription(I18n.getMessage("jsite.preferences.description"));
			}
		});
	}

	/**
	 * Initializes this page.
	 */
	private void pageInit() {
		createActions();
		setLayout(new BorderLayout(12, 12));
		add(createPreferencesPanel(), BorderLayout.CENTER);
	}

	/**
	 * Creates all actions.
	 */
	private void createActions() {
		chooseTempDirectoryAction = new AbstractAction(I18n.getMessage("jsite.preferences.choose-temp-directory")) {

			@Override
			@SuppressWarnings("synthetic-access")
			public void actionPerformed(ActionEvent e) {
				chooseTempDirectory();
			}
		};

		I18nContainer.getInstance().registerRunnable(new Runnable() {

			@Override
			@SuppressWarnings("synthetic-access")
			public void run() {
				chooseTempDirectoryAction.putValue(Action.NAME, I18n.getMessage("jsite.preferences.choose-temp-directory"));
			}
		});
	}

	/**
	 * Creates the panel containing all preferences.
	 *
	 * @return The preferences panel
	 */
	private JPanel createPreferencesPanel() {
		JPanel preferencesPanel = new JPanel(new BorderLayout(12, 12));
		return preferencesPanel;
	}

	/**
	 * Lets the user choose a new temp directory.
	 */
	private void chooseTempDirectory() {
		/* TODO */
	}

}
