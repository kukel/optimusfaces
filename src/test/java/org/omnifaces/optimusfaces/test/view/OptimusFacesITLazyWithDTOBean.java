/*
 * Copyright 2020 OmniFaces
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.omnifaces.optimusfaces.test.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.optimusfaces.model.PagedDataModel;
import org.omnifaces.optimusfaces.test.model.dto.PersonCard;
import org.omnifaces.optimusfaces.test.service.PersonService;

@Named
@ViewScoped
public class OptimusFacesITLazyWithDTOBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PagedDataModel<PersonCard> lazyPersonCards;

	@Inject
	private PersonService personService;

	@PostConstruct
	public void init() {
		lazyPersonCards = PagedDataModel.lazy(personService::getPageOfPersonCards).build();
	}

	public PagedDataModel<PersonCard> getLazyPersonCards() {
		return lazyPersonCards;
	}

}
