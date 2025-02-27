//
// ========================================================================
// Copyright (c) 1995 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.tests.ccd.ee9;

import java.io.IOException;
import java.util.Objects;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String forwardTo = req.getHeader("X-ForwardTo");
        Objects.requireNonNull(forwardTo);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forwardTo);
        requestDispatcher.forward(req, resp);
    }
}
