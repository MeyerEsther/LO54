/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.project.service;

import fr.utbm.lo54.project.model.Location;
import java.util.List;

/**
 *
 * @author Valentin Bourdier
 */
public interface LocationStorerDao {
    
    public List<Location> getRecordsLocation();

}
