/*
 * Copyright 2017 OmniFaces
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.omnifaces.optimusfaces.test.service;

import static org.omnifaces.optimusfaces.test.model.Gender.FEMALE;

import javax.ejb.Stateless;

import org.omnifaces.optimusfaces.test.model.Person;
import org.omnifaces.persistence.model.dto.Page;
import org.omnifaces.persistence.service.BaseEntityService;
import org.omnifaces.utils.collection.PartialResultList;

@Stateless
public class PersonService extends BaseEntityService<Long, Person> {

	public PartialResultList<Person> getPageOfFemales(Page page, boolean count) {
		return getPage(page, count, (builder, query, root) -> {
			query.where(builder.equal(root.get("gender"), FEMALE));
		});
	}

	public PartialResultList<Person> getPageWithAddress(Page page, boolean count) {
		return getPage(page, count, (builder, query, root) -> {
			root.fetch("address");
		});
	}

}
