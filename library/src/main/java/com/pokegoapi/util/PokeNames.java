/*
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.pokegoapi.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Angelo Rüggeberg
 * @author Nyazuki
 */

public class PokeNames {
	/**
	 * Returns the Name for a Pokedex ID including known translations.
	 *
	 * @param pokedex Pokemon index number
	 * @param locale taget name locale
	 * @return the Pokemon name in locale
	 * @throws MissingResourceException if can not find a matched Pokemon name for the given pokedex
	 */
	public static String getDisplayName(int pokedex, Locale locale) throws MissingResourceException {
		ResourceBundle names = ResourceBundle.getBundle("pokemon_names", locale);
		return names.getString(String.valueOf(pokedex));
	}

	/**
	 * Returns translated Pokemon name from ENGLISH locale.
	 *
	 * @param engName pokemon ENGLISH name
	 * @param newLocale the locale you want translate to
	 * @return translated pokemon name
	 * @throws MissingResourceException if can not find a matched Pokemon name for the given pokedex
	 */
	public static String translateName(String engName, Locale newLocale) throws MissingResourceException {
		return getDisplayName(getPokedexFromName(engName), newLocale);
	}

	/**
	 * Returns the Pokemon index from the Pokemon name list.
	 *
	 * @param pokeName pokemon name in locale
	 * @param locale the locale on this name
	 * @return pokedex
	 * @throws MissingResourceException if can not find a matched Pokemon name for the given pokedex
	 */
	public static int getPokedexFromName(String pokeName, Locale locale) throws MissingResourceException {
		ResourceBundle nameList = ResourceBundle.getBundle("pokemon_names", locale);
		for (String key : nameList.keySet()) {
			if (nameList.getString(key).equalsIgnoreCase(pokeName)) {
				return Integer.parseInt(key);
			}
		}
		return -1;
	}

	/**
	 * Returns the Pokemon index from the Pokemon name list in ENGLISH.
	 *
	 * @param pokeName the Pokemon ENGLISH name
	 * @return pokedex
	 * @throws MissingResourceException if can not find a matched Pokemon name for the given pokedex
	 */
	public static int getPokedexFromName(String pokeName) throws MissingResourceException {
		return getPokedexFromName(pokeName, Locale.ENGLISH);
	}
}
