/**
 * Copyright (C) 2012 - 2013 Matija Mazi
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.btce.service.account.polling;

import java.math.BigDecimal;

import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.btce.BTCEAdapters;
import com.xeiam.xchange.btce.BTCEAuthenticated;
import com.xeiam.xchange.btce.dto.marketdata.BTCEAccountInfoReturn;
import com.xeiam.xchange.btce.service.BTCEBasePollingService;
import com.xeiam.xchange.dto.account.AccountInfo;
import com.xeiam.xchange.service.account.polling.PollingAccountService;

/**
 * @author Matija Mazi <br/>
 */
public class BTCEPollingAccountService extends BTCEBasePollingService implements PollingAccountService {

  public BTCEPollingAccountService(ExchangeSpecification spec) {

    super(spec);
  }

  @Override
  public AccountInfo getAccountInfo() {

    BTCEAccountInfoReturn info = btce.getInfo(apiKey, signatureCreator, nextNonce(), null, null, null, null, BTCEAuthenticated.SortOrder.DESC, null, null);
    checkResult(info);
    return BTCEAdapters.adaptAccountInfo(info.getReturnValue());
  }

  @Override
  public String withdrawFunds(BigDecimal amount, String address) {

    throw new UnsupportedOperationException("Funds withdrawal not supported by BTCE API.");
  }

  @Override
  public String requestBitcoinDepositAddress(String description, String notificationUrl) {

    throw new UnsupportedOperationException("Deposit address request not supported by BTCE API.");
  }
}