/*
 * Copyright 2017 Harvard University Library
 *
 * This file is part of FITS (File Information Tool Set).
 *
 * FITS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FITS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.harvard.hul.ois.fits.tools;

import edu.harvard.hul.ois.fits.exceptions.FitsConfigurationException;
import edu.harvard.hul.ois.fits.exceptions.FitsToolException;
import java.io.File;

/**
 * A no-argument trivial implementation of the Tool interface to test reflection in ToolBelt.
 *
 * @see edu.harvard.hul.ois.fits.tools.ToolBeltTest#noArgumentConstructorToolTest()
 */
public class NoArgumentTestTool extends ToolBase implements Tool {

    /**
     * @throws FitsConfigurationException
     */
    public NoArgumentTestTool() throws FitsToolException {
        super();
    }

    @Override
    public ToolOutput extractInfo(File file) throws FitsToolException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setEnabled(boolean value) {
        throw new UnsupportedOperationException();
    }
}
