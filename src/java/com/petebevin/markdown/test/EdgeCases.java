/*
Copyright (c) 2005, Pete Bevin.
<http://markdownj.petebevin.com>

All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

* Redistributions of source code must retain the above copyright notice,
  this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright
  notice, this list of conditions and the following disclaimer in the
  documentation and/or other materials provided with the distribution.

* Neither the name "Markdown" nor the names of its contributors may
  be used to endorse or promote products derived from this software
  without specific prior written permission.

This software is provided by the copyright holders and contributors "as
is" and any express or implied warranties, including, but not limited
to, the implied warranties of merchantability and fitness for a
particular purpose are disclaimed. In no event shall the copyright owner
or contributors be liable for any direct, indirect, incidental, special,
exemplary, or consequential damages (including, but not limited to,
procurement of substitute goods or services; loss of use, data, or
profits; or business interruption) however caused and on any theory of
liability, whether in contract, strict liability, or tort (including
negligence or otherwise) arising in any way out of the use of this
software, even if advised of the possibility of such damage.

*/

package com.petebevin.markdown.test;

import com.petebevin.markdown.MarkdownProcessor;
import junit.framework.TestCase;

import java.util.regex.Pattern;

public class EdgeCases extends TestCase {
    private MarkdownProcessor m;

    public void setUp() {
        m = new MarkdownProcessor();
    }

    public void testEmptyString() {
        assertEquals("\n", m.markdown(""));
    }

    public void testSpaces() {
        assertEquals("\n", m.markdown("  "));
    }

    public void testNull() {
        assertEquals("\n", m.markdown(null));
    }

    public void testSplitAssumption() {
        // In Perl, split(/x/, "") returns the empty string.
        // But in Java, it's the array { "" }.
        Pattern x = Pattern.compile("x");
        String[] xs = x.split("");
        assertEquals (1, xs.length);
        assertEquals("", xs[0]);

    }
}
