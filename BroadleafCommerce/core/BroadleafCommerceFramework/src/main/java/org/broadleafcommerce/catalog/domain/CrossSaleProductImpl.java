/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.catalog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.broadleafcommerce.presentation.AdminPresentation;
import org.hibernate.annotations.Index;
import org.hibernate.envers.Audited;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BLC_PRODUCT_CROSS_SALE")
@Audited
public class CrossSaleProductImpl implements RelatedProduct {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "CrossSaleProductId", strategy = GenerationType.TABLE)
    @TableGenerator(name = "CrossSaleProductId", table = "SEQUENCE_GENERATOR", pkColumnName = "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "CrossSaleProductImpl", allocationSize = 50)
    @Column(name = "CROSS_SALE_PRODUCT_ID")
    private Long id;

    @ManyToOne(targetEntity = ProductImpl.class, optional=false)
    @JoinColumn(name = "PRODUCT_ID")
    @Index(name="CROSSSALE_INDEX", columnNames={"PRODUCT_ID"})
    private Product product = new ProductImpl();

    @ManyToOne(targetEntity = ProductImpl.class, optional=false)
    @JoinColumn(name = "RELATED_SALE_PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @Index(name="CROSSSALE_RELATED_INDEX", columnNames={"RELATED_SALE_PRODUCT_ID"})
    private Product relatedSaleProduct = new ProductImpl();

    @Column(name = "PROMOTION_MESSAGE")
    @AdminPresentation(friendlyName="Promotion Message", largeEntry=true)
    private String promotionMessage;

    @Column(name = "SEQUENCE")
    private Long sequence;

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getPromotionMessage() {
        return promotionMessage;
    }

    public Product getRelatedProduct() {
        return relatedSaleProduct;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public void setRelatedProduct(Product relatedSaleProduct) {
        this.relatedSaleProduct = relatedSaleProduct;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }
}